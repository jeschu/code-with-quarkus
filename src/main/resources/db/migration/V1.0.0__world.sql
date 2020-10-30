DROP TABLE IF EXISTS "city";
CREATE TABLE "city"
(
    "ID"          int      NOT NULL DEFAULT SERIAL,
    "Name"        char(35) NOT NULL DEFAULT '',
    "CountryCode" char(3)  NOT NULL DEFAULT '',
    "District"    char(20) NOT NULL DEFAULT '',
    "Population"  int      NOT NULL DEFAULT 0,
    PRIMARY KEY ("ID")
)