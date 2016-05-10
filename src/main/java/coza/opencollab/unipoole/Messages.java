package coza.opencollab.unipoole;

import java.util.Locale;
import org.springframework.context.MessageSource;

/**
 * This class expose all the messages set in property files.
 * 
 * TODO: Add method where the caller specify the local (Locale locale = RequestContextUtils.getLocale((HttpServletRequest) pageContext.getRequest());)
 * TODO: look at LocaleContextHolder.getLocale()
 * 
 * @author OpenCollab
 * @since 1.0.0
 */
public final class Messages {
    /**
     * The static instance.
     */
    private static Messages instance;
    /**
     * The default locale.
     */
    private static final Locale LOCALE = Locale.getDefault();
    /**
     * The message source for the error codes.
     */
    private static MessageSource errorCodes;
    /**
     * The message source for the error codes.
     */
    private static MessageSource messageSource;
    
    /**
     * Factory creator.
     */
    static Messages createInstance(){
        instance = new Messages();
        return instance;
    }
    
    /**
     * Factory creator.
     */
    static Messages createInstance(MessageSource messageSource, MessageSource errorCodes){
        Messages.messageSource = messageSource;
        Messages.errorCodes = errorCodes;
        return createInstance();
    }
    
    /**
     * Get the message for the key.
     */
    public static String getMessage(String key){
        return getMessage(key, (Object[])null);
    }
    
    /**
     * Get the message for the key and set all the arguments.
     */
    public static String getMessage(String key, Object... arg){
        return messageSource.getMessage(key, arg, LOCALE);
    }
    
    /**
     * Get the error code instruction.
     */
    public static String getErrorInstruction(int code){
        return getErrorInstruction(code, (Object[])null);
    }
    
    /**
     * Get the error code instruction.
     */
    public static String getErrorInstruction(int code, Object... arg){
        return errorCodes.getMessage(code+"_INSTRUCTION", arg, LOCALE);
    }
    
    /**
     * This is a static class.
     */
    private Messages(){}
}
