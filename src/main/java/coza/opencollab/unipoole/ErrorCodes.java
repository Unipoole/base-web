package coza.opencollab.unipoole;

/**
 * The error code manager.
 * <p>
 * Error Code Ranges:
 * <ol>
 *  <li>1000's: This is exceptions on the server</li>
 *  <li>2000's: This is normal flow problems like login details that are not valid.</li>
 *  <li>3000's: Admin tool</li>
 *  <li>4000's: Client base and tools</li>
 * </ol>
 * 
 * @author OpenCollab
 * @since 1.0.0
 */
public class ErrorCodes{
    /**
     * General (unset) error. 
     * <p>
     * Could be anything, anywhere.
     */
    public static final int GENERAL = 1000;
    /**
     * This comes from the JsonParser
     * <p>
     * Tried to parse json to a Object. Either the json is not valid or the json cannot be fitted to the object.
     * Look at the source of the json, it is sending invalid json.
     * Example Messages:
     * <ol>
     *  <li>The character encoding is not supported.</li>
     *  <li>Invalid content mapping.</li>
     *  <li>Could not parse the content.</li>
     *  <li>Could not write the object.</li>
     * </ol>
     */
    public static final int JSON_READ = 1001;
    /**
     * This comes from the BaseWeb JsonParser.writeJson
     * Tried to convert a Object to a json string. For some reason it was unsuccessful. Investigate the Object.
     * Example Messages:
     * <ol>
     *  <li>Invalid content mapping.</li>
     *  <li>Could not write content.</li>
     *  <li>Could not write the object.</li>
     * </ol>
     */
    public static final int JSON_WRITE = 1002;
}
