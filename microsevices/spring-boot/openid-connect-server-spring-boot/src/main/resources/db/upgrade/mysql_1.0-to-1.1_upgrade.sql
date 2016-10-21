--
-- This SQL script will upgrade your MITREid Connect 1.0 database to a MITREid Connect 1.1 database in-place. 
-- 
-- NOTICE: Any authorization codes that have not been activated will be removed.
-- 

ALTER TABLE access_token ADD COLUMN approved_site_id BIGINT;

TRUNCATE TABLE authorization_code;

ALTER TABLE authorization_code DROP COLUMN authorization_request_holder;

ALTER TABLE authorization_code ADD COLUMN authentication LONGBLOB;

ALTER TABLE client_details MODIFY id_token_validity_seconds BIGINT NOT NULL DEFAULT 600;

ALTER TABLE client_details ADD COLUMN token_endpoint_auth_signing_alg VARCHAR(256);
	
ALTER TABLE system_scope ADD COLUMN structured BOOLEAN NOT NULL DEFAULT 0;

ALTER TABLE system_scope ADD COLUMN structured_param_description VARCHAR(256);

ALTER TABLE user_info ADD COLUMN phone_number_verified BOOLEAN;

DROP TABLE client_nonce;

DROP TABLE event;

DROP TEMPORARY TABLE IF EXISTS authorities_TEMP;

DROP TEMPORARY TABLE IF EXISTS users_TEMP;

DROP TEMPORARY TABLE IF EXISTS user_info_TEMP;

DROP TEMPORARY TABLE IF EXISTS client_details_TEMP;

DROP TEMPORARY TABLE IF EXISTS client_scope_TEMP;

DROP TEMPORARY TABLE IF EXISTS client_redirect_uri_TEMP;

DROP TEMPORARY TABLE IF EXISTS client_grant_type_TEMP;

DROP TEMPORARY TABLE IF EXISTS system_scope_TEMP;


CREATE TABLE IF NOT EXISTS pairwise_identifier (
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
	identifier VARCHAR(256),
	sub VARCHAR(256),
	sector_identifier VARCHAR(2048)
);
