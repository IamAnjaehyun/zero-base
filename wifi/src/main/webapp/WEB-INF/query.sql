# SQLITE
# 직접 사용은 intellij console에서 사용


# CREATE TABLE WIFI
# (
#     X_SWIFI_MGR_NO      VARCHAR2(4000),
#     X_SWIFI_WRDOFC      VARCHAR2(4000),
#     X_SWIFI_MAIN_NM     VARCHAR2(4000),
#     X_SWIFI_ADRES1      VARCHAR2(4000),
#     X_SWIFI_ADRES2      VARCHAR2(4000),
#     X_SWIFI_INSTL_FLOOR VARCHAR2(4000),
#     X_SWIFI_INSTL_TY    VARCHAR2(4000),
#     X_SWIFI_INSTL_MBY   VARCHAR2(4000),
#     X_SWIFI_SVC_SE      VARCHAR2(4000),
#     X_SWIFI_CMCWR       VARCHAR2(4000),
#     X_SWIFI_CNSTC_YEAR  VARCHAR2(4000),
#     X_SWIFI_INOUT_DOOR  VARCHAR2(4000),
#     X_SWIFI_REMARS3     VARCHAR2(4000),
#     LAT                 float(4000),
#     LNT                 float(4000),
#     WORK_DTTM           TIMESTAMP
# ); drop table WIFI;
#
# CREATE TABLE HISTORY
# (
#     ID           INTEGER PRIMARY KEY AUTOINCREMENT,
#     LAT          float(4000),
#     LNT          float(4000),
#     CREATED_TIME TIMESTAMP
# ); drop table HISTORY;
#
#
# CREATE TABLE BOOKMARKLIST
# (
#     ID           integer primary key autoincrement,
#     NAME         VARCHAR2(4000),
#     NUM          int(1000) UNIQUE,
#     CREATED_TIME TIMESTAMP,
#     FIXED_TIME   TIMESTAMP
# ); drop table BOOKMARKLIST;
#
# CREATE TABLE BOOKMARK
# (
#     ID           INTEGER PRIMARY KEY AUTOINCREMENT,
#     WIFI_NAME    VARCHAR2(4000),
#     MGR_NO       VARCHAR2(4000),
#     CREATED_TIME TIMESTAMP,
#     LIST_ID      INTEGER,
#     FOREIGN KEY (LIST_ID)
#         REFERENCES BOOKMARKLIST (ID)
#         ON UPDATE CASCADE
#         ON DELETE CASCADE
# ); drop table BOOKMARK;
# select * from BOOKMARKLIST;
# select * from HISTORY;