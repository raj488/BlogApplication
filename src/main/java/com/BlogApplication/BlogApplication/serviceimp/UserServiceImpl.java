package com.BlogApplication.BlogApplication.serviceimp;

import com.BlogApplication.BlogApplication.entities.User;
import com.BlogApplication.BlogApplication.exception.ResourceNotFoundException;
import com.BlogApplication.BlogApplication.payload.UserDto;
import com.BlogApplication.BlogApplication.repo.UserRepo;
import com.BlogApplication.BlogApplication.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private ModelMapper modelMapper;
   @Autowired
   private UserRepo userRepo;


    @Override
    public UserDto createUser(UserDto userdto) {

        User map=this.modelMapper.map(userdto, User.class);
        User addedUser=this.userRepo.save(map);

        return this.modelMapper.map(addedUser, UserDto.class);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer userId) {

       User cat=this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","User Id",userId));

       cat.setName(userDto.getName());
       cat.setAge(userDto.getAge());
       cat.setEmail(userDto.getEmail());
       cat.setGender(userDto.getGender());
       cat.setPassword(userDto.getPassword());
       User updateduser=this.userRepo.save(cat);



        return this.modelMapper.map(updateduser,UserDto.class);
    }

    @Override
    public UserDto getUserById(Integer userId) {
        User cat=this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","User Id",userId));

        return this.modelMapper.map(cat,UserDto.class);
    }

    @Override
    public List<UserDto> getAllUsers() {

       List<User> users=this.userRepo.findAll();
       List<UserDto> userDtos=users.stream().map((cat)->this.modelMapper.map(cat,UserDto.class)).collect(Collectors.toList());
        return null;
    }

    @Override
    public void deleteUser(Integer userId) {
        User cat=this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","User Id",userId));
        this.userRepo.delete(cat);

    }
}