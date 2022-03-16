package com.shopdesk.hitech.entities;

public class ConvertUserDTO {
    public static UserDTO ConvertUser(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setFullName(user.getFullName());
        userDTO.setEmail(user.getEmail());
        userDTO.setUsername(user.getUsername());
        userDTO.setJoinedAt(user.getJoinedAt());
        userDTO.setLastEditAt(user.getLastEditAt());
        userDTO.setActive(user.getActive());
        return userDTO;
    }
}
