package com.example.lit.mapper;


import com.example.lit.domain.vo.SearchDTO;
import com.example.lit.domain.vo.user.UserVO;
import com.example.lit.mapper.user.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class UserMapperTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void insertTest(){
        UserVO userVO = new UserVO();
        userVO.setEmail("abc");
        userVO.setName("asd");
        userVO.setNickname("azx");
        userVO.setPassword("1234");
        log.info("userVO: "+userVO);
        userMapper.insert(userVO);
    }

    @Test
    public void loginTest(){
        String email="test12";
        String password = "1234";
        log.info(userMapper.login(email,password)+"");
    }

    @Test
    public void deleteTest(){
        Long userNumber = 621L;
        userMapper.delete(userNumber);
    }

    @Test
    public void getUserTest(){
        Long userNumber = 622L;
        userMapper.getUser(userNumber);
        log.info(userMapper.getUser(userNumber).toString());
    }

    @Test
    public void updateTest(){
        UserVO userVO = new UserVO();
        userVO.setName("updateTest");
        userVO.setNickname("updateTest");
        userVO.setEmail("updateTest");
        userVO.setContent("updateTest");
        userVO.setUserNumber(622L);

        userMapper.update(userVO);
    }

    @Test
    public void updatePwTest(){
        UserVO userVO = new UserVO();
        userVO.setUserNumber(622L);
        userVO.setPassword("2345");
        String newPassword="1234";

        userMapper.updatePw(userVO,newPassword);
    }

    @Test
    public void updateMedalTest(){
        UserVO userVO = new UserVO();
        userVO.setUserNumber(622L);
        userVO.setAchievementNumber(1L);

        userMapper.updateMedal(userVO);
    }

    @Test
    public void adminSelect(){
//        SELECT USER_NUMBER, EMAIL, NAME, NICKNAME, PASSWORD, CONTENT, KAKAO, REGISTER_DATE, ACHIEVEMENT_NUMBER
//        FROM TBL_USER
//        WHERE EMAIL LIKE '%test%'
//        AND KAKAO IS NULL
//        AND REGISTER_DATE > '2022-06-14' AND REGISTER_DATE < '2022-06-16';
        SearchDTO search = new SearchDTO();
        search.setStartDate("2022-06-14");
        search.setEndDate("2022-06-16");
        search.setKeyword("test");
        search.setType("email");
        search.setKakao("2"); // kakao를 0(all), 1(null), 2(not null) 로 받아서 검사하기
        userMapper.userSearch(search).stream().map(UserVO::toString).forEach(log::info);
    }

}
