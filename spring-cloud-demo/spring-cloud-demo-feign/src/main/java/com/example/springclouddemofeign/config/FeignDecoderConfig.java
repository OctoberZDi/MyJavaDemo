package com.example.springclouddemofeign.config;

import feign.FeignException;
import feign.Response;
import feign.codec.DecodeException;
import feign.codec.Decoder;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: FeignDecoderConfig
 * @Description: dd
 * @Author: zhangdi
 * @Date: 2020年05月23日 15:06
 **/
@Configuration
public class FeignDecoderConfig implements Decoder {
    //@Autowired
    //private ObjectFactory<HttpMessageConverters> messageConverters;

    //@Bean
    public Decoder feignDecoder() {
        return new ResponseEntityDecoder(new SpringDecoder(this.getObjectFactory()));
    }

    private ObjectFactory<HttpMessageConverters> getObjectFactory() {
        HttpMessageConverters httpMessageConverters =
                new HttpMessageConverters(new MyMappingJackson2HttpMessageConverter());
        return new ObjectFactory<HttpMessageConverters>() {
            @Override
            public HttpMessageConverters getObject() throws BeansException {
                return httpMessageConverters;
            }
        };
    }

    private boolean isParameterizeHttpEntity(Type type) {
        return true;
        //return type instanceof ParameterizedType && this.isHttpEntity(((ParameterizedType) type).getRawType());
    }

    @Override
    public Object decode(Response response, Type type) throws IOException, DecodeException, FeignException {
        if (this.isParameterizeHttpEntity(type)) {
            type = ((ParameterizedType) type).getActualTypeArguments()[0];
            Object decodedObject = this.decode(response, type);
            return this.createResponse(decodedObject, response);
        } else {
            return this.isHttpEntity(type) ? this.createResponse((Object) null, response) :
                    this.decode(response, type);
        }
    }

    private boolean isHttpEntity(Type type) {
        if (type instanceof Class) {
            Class c = (Class) type;
            return HttpEntity.class.isAssignableFrom(c);
        } else {
            return false;
        }
    }

    private <T> ResponseEntity<T> createResponse(Object instance, Response response) {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap();
        Iterator var4 = response.headers().keySet().iterator();

        while (var4.hasNext()) {
            String key = (String) var4.next();
            headers.put(key, new LinkedList((Collection) response.headers().get(key)));
        }

        return new ResponseEntity(instance, headers, HttpStatus.valueOf(response.status()));
    }

    public class MyMappingJackson2HttpMessageConverter extends MappingJackson2HttpMessageConverter {
        public MyMappingJackson2HttpMessageConverter() {
            List<MediaType> mediaTypes = new ArrayList<>();
            mediaTypes.add(MediaType.ALL);
            setSupportedMediaTypes(mediaTypes);
        }
    }
}
