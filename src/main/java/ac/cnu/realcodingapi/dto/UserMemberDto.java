package ac.cnu.realcodingapi.dto;

import ac.cnu.realcodingapi.domain.member.UserMember;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public class UserMemberDto implements Serializable {
    private String name;
    private String studentId;
    private long groupId;
    private String role; // TODO: enum 으로 변경

    public static UserMember toEntity(UserMemberDto m) {
        return new UserMember(m.getStudentId(), m.getName(), m.getGroupId(), m.getRole());
    }

    public static UserMemberDto create(UserMember m) {
        return new UserMemberDto(m.getName(), m.getStudentId(), m.getUserGroupId(), m.getRole());
    }

    public static Set<UserMember> toMemberEntities(UserGroupRequest userGroupRequest) {
        return userGroupRequest.getMembers()
                .stream()
                .map(UserMemberDto::toEntity)
                .collect(Collectors.toSet());
    }
}
