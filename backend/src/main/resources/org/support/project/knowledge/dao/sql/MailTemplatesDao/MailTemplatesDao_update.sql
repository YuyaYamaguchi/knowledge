UPDATE MAIL_TEMPLATES
SET 
   TEMPLATE_TITLE = ?
 , DESCRIPTION = ?
 , INSERT_USER = ?
 , INSERT_DATETIME = ?
 , UPDATE_USER = ?
 , UPDATE_DATETIME = ?
 , DELETE_FLAG = ?
WHERE 
TEMPLATE_ID = ?
;
