-- STANDARD
INSERT INTO `t_control` (`type`, `k`, `description`) VALUES ('STANDARD', 'REQUIRED', 'Rende il campo obbligatorio');
INSERT INTO `t_control` (`type`, `k`, `description`) VALUES ('STANDARD', 'EQUAL', 'Verifica che il campo sia uguale ad un determinato valore');
INSERT INTO `t_control` (`type`, `k`, `description`) VALUES ('STANDARD', 'NOT_EQUAL', 'Verifica che il campo sia diverso da un determinato valore');
INSERT INTO `t_control` (`type`, `k`, `description`) VALUES ('STANDARD', 'PATTERN', 'Verifica che il campo rispetti una determinata Regex');
INSERT INTO `t_control` (`type`, `k`, `description`) VALUES ('STANDARD', 'IN', 'Verifica che il campo sia compreso in un insieme di determinati valori');
INSERT INTO `t_control` (`type`, `k`, `description`) VALUES ('STANDARD', 'NOT_IN', 'Verifica che il campo sia diverso da un insieme di determinati valori');
INSERT INTO `t_control` (`type`, `k`, `description`) VALUES ('STANDARD', 'MIN_TEXT', '	Verifica che la lunghezza del testo inserito sia superiore ad un determinato valore');
INSERT INTO `t_control` (`type`, `k`, `description`) VALUES ('STANDARD', 'MAX_TEXT', 'Verifica che la lunghezza del testo inserito sia inferiore ad un determinato valore');
INSERT INTO `t_control` (`type`, `k`, `description`) VALUES ('STANDARD', 'MIN_NUM', 'Verifica che il numero inserito sia superiore ad un determinato numero');
INSERT INTO `t_control` (`type`, `k`, `description`) VALUES ('STANDARD', 'MAX_NUM', 'Verifica che il numero inserito sia inferiore ad un determinato numero');

-- COMPLEX
INSERT INTO `t_control` (`type`, `k`, `description`) VALUES ('COMPLEX', 'EQUAL', 'Verifica che il campo A sia uguale al campo B');
INSERT INTO `t_control` (`type`, `k`, `description`) VALUES ('COMPLEX', 'NOT_EQUAL', 'Verifica che il campo A sia diverso dal campo B');
INSERT INTO `t_control` (`type`, `k`, `description`) VALUES ('COMPLEX', 'MIN', 'Verifica che il campo A sia maggiore del campo B');
INSERT INTO `t_control` (`type`, `k`, `description`) VALUES ('COMPLEX', 'MAX', 'Verifica che il campo A sia minore del campo B');
