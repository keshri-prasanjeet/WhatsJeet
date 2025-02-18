package com.keshrixlabs.neoanthrop.message;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    @Query(name = MessageConstants.FIND_MESSAGES_BY_CHAT_ID)
    List<Message> findMessagesByChatId(String chatId);

    @Query(name = MessageConstants.CHANGE_MESSAGE_STATE_BY_CHAT_ID)
    @Modifying
    void changeMessageStateByChatId(@Param("chatId") String chatId,
                                    @Param("newState") MessageState state);

}
