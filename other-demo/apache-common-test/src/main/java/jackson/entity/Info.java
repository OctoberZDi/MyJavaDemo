package jackson.entity;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: Info
 * @Description:
 * @Author: zhangdi
 * @Date: 2021年07月05日 11:28
 **/
public class Info {
    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Info{" +
                "score=" + score +
                ", comment='" + comment + '\'' +
                '}';
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    private int score;
    private String comment;
}
