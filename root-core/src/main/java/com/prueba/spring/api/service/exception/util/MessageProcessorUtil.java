package com.prueba.spring.api.service.exception.util;

import com.prueba.spring.api.service.enums.MessagesEnum;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

/**
 * Utility for handling messages.
 *
 * @author ecasa on 2024/05/02.
 * @version 1.0.0
 */
@Component
public class MessageProcessorUtil {

    private final transient MessageSource messageSource;

    /**
     * Constructor.
     *
     * @param messageSource
     */
    public MessageProcessorUtil(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    /**
     * Used to process the message from enum class.
     *
     * @param mensajeEnum
     * @return a string value from enum class.
     */
    public String getMessage(MessagesEnum mensajeEnum) {
        return messageSource.getMessage(
                mensajeEnum.toString(),
                null,
                LocaleContextHolder.getLocale());
    }

}
