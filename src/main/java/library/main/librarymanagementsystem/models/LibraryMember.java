package library.main.librarymanagementsystem.models;

import java.util.UUID;

public class LibraryMember extends Person{
    String memberId;
    public LibraryMember(String name) {
        super(name);
        memberId= UUID.randomUUID().toString();
    }

    @Override
    public String toString() {
        return
                super.getName();

    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }
}
