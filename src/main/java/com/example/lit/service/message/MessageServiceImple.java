package com.example.lit.service.message;

import com.example.lit.domain.dao.message.MessageDAO;
import com.example.lit.domain.vo.messsage.MessageDTO;
import com.example.lit.domain.vo.messsage.MessageVO;
import com.example.lit.domain.vo.user.UserVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class MessageServiceImple implements MessageService{
    private final MessageDAO messageDAO;

    @Override
    public void register(MessageVO messageVO) {
        messageDAO.register(messageVO);
    }

    @Override
    public List<MessageVO> getList(String roomId) {
        return messageDAO.getList(roomId);
    }

    @Override
    public List<UserVO> getFollowerList(Long userNumber) {
        return messageDAO.getFollowerList(userNumber);
    }

    @Override
    public List<Long> getReceiveUserNumber(Long sendUserNumber) {
        return messageDAO.getReceiveUserNumber(sendUserNumber);
    }

    @Override
    public Map<String, Object> getRecentMessage(Long receiveUserNumber) {
        return messageDAO.getRecentMessage(receiveUserNumber);
    }

    @Override
    public List<UserVO> searchFollower(String keyword, Long userNumber) {
        return messageDAO.searchFollower(keyword,userNumber);
    }

//    @Override
//    public List<MessageDTO> getMessageList(MessageDTO messageDTO, Long sendUserNumber, Long receiveUserNumber) {
//        return messageDAO.getMessageList(messageDTO, sendUserNumber, receiveUserNumber);
//
//    }
    @Override
    public List<MessageDTO> getMessageList(MessageDTO messageDTO) {
        return messageDAO.getMessageList(messageDTO);

    }
}
