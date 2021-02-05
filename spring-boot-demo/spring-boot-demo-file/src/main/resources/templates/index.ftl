<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <!-- Required meta tags -->
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Spring Boot File Upload / Download Rest API Example</title>

    <!-- Bootstrap CSS -->
    <link href="/css/main.css" rel="stylesheet"/>
</head>
<body>

<noscript>
    <h2>Sorry! Your browser doesn't support Javascript</h2>
</noscript>

<div class="upload-container">
    <div class="upload-header">
        <h2>Spring Boot File Upload / Download Rest API Example</h2>
    </div>
    <div class="upload-content">
        <div class="single-upload">
            <h3>Upload Single File</h3>
            <form id="singleUploadForm" name="singleUploadForm">
                <input id="singleFileUploadInput" type="file" name="file" class="file-input" required/>
                <button type="submit" class="primary submit-btn">Submit</button>
            </form>
            <div class="upload-response">
                <div id="singleFileUploadError"></div>
                <div id="singleFileUploadSuccess"></div>
            </div>
        </div>
        <div class="multiple-upload">
            <h3>Upload Multiple Files</h3>
            <form id="multipleUploadForm" name="multipleUploadForm">
                <input id="multipleFileUploadInput" type="file" name="files" class="file-input" multiple required/>
                <button type="submit" class="primary submit-btn">Submit</button>
            </form>
            <div class="upload-response">
                <div id="multipleFileUploadError"></div>
                <div id="multipleFileUploadSuccess"></div>
            </div>
        </div>
    </div>
</div>

<!-- Optional JavaScript -->
<script src="/js/main.js"></script>
</body>
</html>