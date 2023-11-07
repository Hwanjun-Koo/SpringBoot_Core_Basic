package hello.core.member;

//도메인 객체(회원)
public class Member {

    private Long id;
    private String name;
    private Grade grade;

    //생성자 만들기(어노테이션 안쓸거라서 직접 만들어줌
    public Member(Long id, String name, Grade grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }
}
