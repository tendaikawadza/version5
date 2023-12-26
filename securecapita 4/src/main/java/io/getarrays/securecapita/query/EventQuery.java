package io.getarrays.securecapita.query;

/**
 * @author Junior RT
 * @version 1.0
 * @license Get Arrays, LLC (https://getarrays.io)
 * @since 3/21/2023
 */
public class EventQuery {
    public static final String SELECT_EVENTS_BY_USER_ID_QUERY = "SELECT uev.id, uev.device, uev.ip_address, ev.type, ev.description, uev.created_at FROM Events ev JOIN UserEvents uev ON ev.id = uev.event_id JOIN Users u ON u.id = uev.user_id WHERE u.id = :id ORDER BY uev.created_at DESC LIMIT 10";
    public static final String INSERT_EVENT_BY_USER_EMAIL_QUERY = "INSERT INTO UserEvents (user_id, event_id, device, ip_address) VALUES ((SELECT id FROM Users WHERE email = :email), (SELECT id FROM Events WHERE type = :type), :device, :ipAddress)";
    public static final String INSERT_EVENT_BY_USER_ID_QUERY = "INSERT INTO UserEvents (user_id, event_id, device, ip_address) VALUES (:userId, (SELECT id FROM Events WHERE type = :type), :device, :ipAddress)";



}
