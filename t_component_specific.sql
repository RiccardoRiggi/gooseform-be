-- GOOSE_TEXT_AREA
INSERT INTO `t_component_specific` (`type`, `k`, `v`) VALUES ('GOOSE_TEXT_AREA', 'rows', 'Number');

-- GOOSE_SELECT
INSERT INTO `t_component_specific` (`type`, `k`, `v`) VALUES ('GOOSE_SELECT', 'size', 'Number');
INSERT INTO `t_component_specific` (`type`, `k`, `v`) VALUES ('GOOSE_SELECT', 'values', 'List<GooseKeyValue>');
INSERT INTO `t_component_specific` (`type`, `k`, `v`) VALUES ('GOOSE_SELECT', 'dynamicValues', 'GooseHttpRequest');
INSERT INTO `t_component_specific` (`type`, `k`, `v`) VALUES ('GOOSE_SELECT', 'keyName', 'String');
INSERT INTO `t_component_specific` (`type`, `k`, `v`) VALUES ('GOOSE_SELECT', 'valueName', 'String');

-- GOOSE_LINKED_SELECT
INSERT INTO `t_component_specific` (`type`, `k`, `v`) VALUES ('GOOSE_LINKED_SELECT', 'size', 'Number');
INSERT INTO `t_component_specific` (`type`, `k`, `v`) VALUES ('GOOSE_LINKED_SELECT', 'dynamicValues', 'GooseHttpRequest');
INSERT INTO `t_component_specific` (`type`, `k`, `v`) VALUES ('GOOSE_LINKED_SELECT', 'keyName', 'String');
INSERT INTO `t_component_specific` (`type`, `k`, `v`) VALUES ('GOOSE_LINKED_SELECT', 'valueName', 'String');
INSERT INTO `t_component_specific` (`type`, `k`, `v`) VALUES ('GOOSE_LINKED_SELECT', 'idLinkedSelectPadre', 'String');
INSERT INTO `t_component_specific` (`type`, `k`, `v`) VALUES ('GOOSE_LINKED_SELECT', 'idLinkedSelectFiglia', 'String');

-- GOOSE_DATA_LIST
INSERT INTO `t_component_specific` (`type`, `k`, `v`) VALUES ('GOOSE_DATA_LIST', 'name', 'String');
INSERT INTO `t_component_specific` (`type`, `k`, `v`) VALUES ('GOOSE_DATA_LIST', 'placeholder', 'String');
INSERT INTO `t_component_specific` (`type`, `k`, `v`) VALUES ('GOOSE_DATA_LIST', 'readonly', 'Boolean');
INSERT INTO `t_component_specific` (`type`, `k`, `v`) VALUES ('GOOSE_DATA_LIST', 'disabled', 'Boolean');
INSERT INTO `t_component_specific` (`type`, `k`, `v`) VALUES ('GOOSE_DATA_LIST', 'values', 'List<GooseKeyValue>');
INSERT INTO `t_component_specific` (`type`, `k`, `v`) VALUES ('GOOSE_DATA_LIST', 'dynamicValues', 'GooseHttpRequest');
INSERT INTO `t_component_specific` (`type`, `k`, `v`) VALUES ('GOOSE_DATA_LIST', 'keyName', 'String');
INSERT INTO `t_component_specific` (`type`, `k`, `v`) VALUES ('GOOSE_DATA_LIST', 'valueName', 'String');

-- GOOSE_TEXT_FIELD
INSERT INTO `t_component_specific` (`type`, `k`, `v`) VALUES ('GOOSE_TEXT_FIELD', 'name', 'String');
INSERT INTO `t_component_specific` (`type`, `k`, `v`) VALUES ('GOOSE_TEXT_FIELD', 'placeholder', 'String');
INSERT INTO `t_component_specific` (`type`, `k`, `v`) VALUES ('GOOSE_TEXT_FIELD', 'disabled', 'Boolean');
INSERT INTO `t_component_specific` (`type`, `k`, `v`) VALUES ('GOOSE_TEXT_FIELD', 'readonly', 'Boolean');

-- GOOSE_PASSWORD_FIELD
INSERT INTO `t_component_specific` (`type`, `k`, `v`) VALUES ('GOOSE_PASSWORD_FIELD', 'name', 'String');
INSERT INTO `t_component_specific` (`type`, `k`, `v`) VALUES ('GOOSE_PASSWORD_FIELD', 'placeholder', 'String');
INSERT INTO `t_component_specific` (`type`, `k`, `v`) VALUES ('GOOSE_PASSWORD_FIELD', 'disabled', 'Boolean');
INSERT INTO `t_component_specific` (`type`, `k`, `v`) VALUES ('GOOSE_PASSWORD_FIELD', 'readonly', 'Boolean');

-- GOOSE_NUMBER_FIELD
INSERT INTO `t_component_specific` (`type`, `k`, `v`) VALUES ('GOOSE_NUMBER_FIELD', 'name', 'String');
INSERT INTO `t_component_specific` (`type`, `k`, `v`) VALUES ('GOOSE_NUMBER_FIELD', 'placeholder', 'String');
INSERT INTO `t_component_specific` (`type`, `k`, `v`) VALUES ('GOOSE_NUMBER_FIELD', 'disabled', 'Boolean');
INSERT INTO `t_component_specific` (`type`, `k`, `v`) VALUES ('GOOSE_NUMBER_FIELD', 'readonly', 'Boolean');
INSERT INTO `t_component_specific` (`type`, `k`, `v`) VALUES ('GOOSE_NUMBER_FIELD', 'steps', 'Number');

-- GOOSE_RADIO
INSERT INTO `t_component_specific` (`type`, `k`, `v`) VALUES ('GOOSE_RADIO', 'size', 'Number');
INSERT INTO `t_component_specific` (`type`, `k`, `v`) VALUES ('GOOSE_RADIO', 'values', 'List<GooseKeyValue>');
INSERT INTO `t_component_specific` (`type`, `k`, `v`) VALUES ('GOOSE_RADIO', 'name', 'String');
INSERT INTO `t_component_specific` (`type`, `k`, `v`) VALUES ('GOOSE_RADIO', 'disabled', 'Boolean');
INSERT INTO `t_component_specific` (`type`, `k`, `v`) VALUES ('GOOSE_RADIO', 'readonly', 'Boolean');
INSERT INTO `t_component_specific` (`type`, `k`, `v`) VALUES ('GOOSE_RADIO', 'dynamicValues', 'GooseHttpRequest');
INSERT INTO `t_component_specific` (`type`, `k`, `v`) VALUES ('GOOSE_RADIO', 'keyName', 'String');
INSERT INTO `t_component_specific` (`type`, `k`, `v`) VALUES ('GOOSE_RADIO', 'valueName', 'String');

-- GOOSE_CHECKBOX
INSERT INTO `t_component_specific` (`type`, `k`, `v`) VALUES ('GOOSE_CHECKBOX', 'name', 'String');
INSERT INTO `t_component_specific` (`type`, `k`, `v`) VALUES ('GOOSE_CHECKBOX', 'disabled', 'Boolean');
INSERT INTO `t_component_specific` (`type`, `k`, `v`) VALUES ('GOOSE_CHECKBOX', 'readonly', 'Boolean');

-- GOOSE_EMAIL_FIELD
INSERT INTO `t_component_specific` (`type`, `k`, `v`) VALUES ('GOOSE_EMAIL_FIELD', 'name', 'String');
INSERT INTO `t_component_specific` (`type`, `k`, `v`) VALUES ('GOOSE_EMAIL_FIELD', 'placeholder', 'String');
INSERT INTO `t_component_specific` (`type`, `k`, `v`) VALUES ('GOOSE_EMAIL_FIELD', 'disabled', 'Boolean');
INSERT INTO `t_component_specific` (`type`, `k`, `v`) VALUES ('GOOSE_EMAIL_FIELD', 'readonly', 'Boolean');

-- GOOSE_DATE_FIELD
INSERT INTO `t_component_specific` (`type`, `k`, `v`) VALUES ('GOOSE_DATE_FIELD', 'name', 'String');
INSERT INTO `t_component_specific` (`type`, `k`, `v`) VALUES ('GOOSE_DATE_FIELD', 'disabled', 'Boolean');
INSERT INTO `t_component_specific` (`type`, `k`, `v`) VALUES ('GOOSE_DATE_FIELD', 'readonly', 'Boolean');

-- GOOSE_DATE_TIME_FIELD
INSERT INTO `t_component_specific` (`type`, `k`, `v`) VALUES ('GOOSE_DATE_TIME_FIELD', 'name', 'String');
INSERT INTO `t_component_specific` (`type`, `k`, `v`) VALUES ('GOOSE_DATE_TIME_FIELD', 'disabled', 'Boolean');
INSERT INTO `t_component_specific` (`type`, `k`, `v`) VALUES ('GOOSE_DATE_TIME_FIELD', 'readonly', 'Boolean');

-- GOOSE_MONTH_FIELD
INSERT INTO `t_component_specific` (`type`, `k`, `v`) VALUES ('GOOSE_MONTH_FIELD', 'name', 'String');
INSERT INTO `t_component_specific` (`type`, `k`, `v`) VALUES ('GOOSE_MONTH_FIELD', 'disabled', 'Boolean');
INSERT INTO `t_component_specific` (`type`, `k`, `v`) VALUES ('GOOSE_MONTH_FIELD', 'readonly', 'Boolean');

-- GOOSE_WEEK_FIELD
INSERT INTO `t_component_specific` (`type`, `k`, `v`) VALUES ('GOOSE_WEEK_FIELD', 'name', 'String');
INSERT INTO `t_component_specific` (`type`, `k`, `v`) VALUES ('GOOSE_WEEK_FIELD', 'disabled', 'Boolean');
INSERT INTO `t_component_specific` (`type`, `k`, `v`) VALUES ('GOOSE_WEEK_FIELD', 'readonly', 'Boolean');

-- GOOSE_TIME_FIELD
INSERT INTO `t_component_specific` (`type`, `k`, `v`) VALUES ('GOOSE_TIME_FIELD', 'name', 'String');
INSERT INTO `t_component_specific` (`type`, `k`, `v`) VALUES ('GOOSE_TIME_FIELD', 'disabled', 'Boolean');
INSERT INTO `t_component_specific` (`type`, `k`, `v`) VALUES ('GOOSE_TIME_FIELD', 'readonly', 'Boolean');

-- GOOSE_TEL_FIELD
INSERT INTO `t_component_specific` (`type`, `k`, `v`) VALUES ('GOOSE_TEL_FIELD', 'name', 'String');
INSERT INTO `t_component_specific` (`type`, `k`, `v`) VALUES ('GOOSE_TEL_FIELD', 'placeholder', 'String');
INSERT INTO `t_component_specific` (`type`, `k`, `v`) VALUES ('GOOSE_TEL_FIELD', 'disabled', 'Boolean');
INSERT INTO `t_component_specific` (`type`, `k`, `v`) VALUES ('GOOSE_TEL_FIELD', 'readonly', 'Boolean');

-- GOOSE_URL_FIELD
INSERT INTO `t_component_specific` (`type`, `k`, `v`) VALUES ('GOOSE_URL_FIELD', 'name', 'String');
INSERT INTO `t_component_specific` (`type`, `k`, `v`) VALUES ('GOOSE_URL_FIELD', 'placeholder', 'String');
INSERT INTO `t_component_specific` (`type`, `k`, `v`) VALUES ('GOOSE_URL_FIELD', 'disabled', 'Boolean');
INSERT INTO `t_component_specific` (`type`, `k`, `v`) VALUES ('GOOSE_URL_FIELD', 'readonly', 'Boolean');

-- GOOSE_COLOR_FIELD
INSERT INTO `t_component_specific` (`type`, `k`, `v`) VALUES ('GOOSE_COLOR_FIELD', 'name', 'String');
INSERT INTO `t_component_specific` (`type`, `k`, `v`) VALUES ('GOOSE_COLOR_FIELD', 'disabled', 'Boolean');
INSERT INTO `t_component_specific` (`type`, `k`, `v`) VALUES ('GOOSE_COLOR_FIELD', 'readonly', 'Boolean');

-- GOOSE_RANGE_FIELD
INSERT INTO `t_component_specific` (`type`, `k`, `v`) VALUES ('GOOSE_RANGE_FIELD', 'name', 'String');
INSERT INTO `t_component_specific` (`type`, `k`, `v`) VALUES ('GOOSE_RANGE_FIELD', 'disabled', 'Boolean');
INSERT INTO `t_component_specific` (`type`, `k`, `v`) VALUES ('GOOSE_RANGE_FIELD', 'readonly', 'Boolean');
INSERT INTO `t_component_specific` (`type`, `k`, `v`) VALUES ('GOOSE_RANGE_FIELD', 'steps', 'Number');
INSERT INTO `t_component_specific` (`type`, `k`, `v`) VALUES ('GOOSE_RANGE_FIELD', 'min', 'Number');
INSERT INTO `t_component_specific` (`type`, `k`, `v`) VALUES ('GOOSE_RANGE_FIELD', 'max', 'Number');

