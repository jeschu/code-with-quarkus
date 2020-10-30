DROP TABLE IF EXISTS "city";
DROP TABLE IF EXISTS "country";

CREATE TABLE "country" (
    "Code" char(3) NOT NULL DEFAULT '',
    "Name" char(52) NOT NULL DEFAULT '',
    "Continent" char(20) NOT NULL DEFAULT 'Asia',
    "Region" char(26) NOT NULL DEFAULT '',
    "SurfaceArea" decimal(10,2) NOT NULL DEFAULT '0.00',
    "IndepYear" smallint DEFAULT NULL,
    "Population" int NOT NULL DEFAULT '0',
    "LifeExpectancy" decimal(3,1) DEFAULT NULL,
    "GNP" decimal(10,2) DEFAULT NULL,
    "GNPOld" decimal(10,2) DEFAULT NULL,
    "LocalName" char(45) NOT NULL DEFAULT '',
    "GovernmentForm" char(45) NOT NULL DEFAULT '',
    "HeadOfState" char(60) DEFAULT NULL,
    "Capital" int DEFAULT NULL,
    "Code2" char(2) NOT NULL DEFAULT '',
    PRIMARY KEY ("Code")
);

CREATE TABLE "city" (
    "ID" SERIAL NOT NULL,
    "Name" CHAR(35) NOT NULL DEFAULT '',
    "CountryCode" CHAR(3) NOT NULL DEFAULT '',
    "District" CHAR(20) NOT NULL DEFAULT '',
    "Population" INT NOT NULL DEFAULT 0,
    PRIMARY KEY ("ID"),
    CONSTRAINT "city2country" FOREIGN KEY ("CountryCode") REFERENCES "country"
);

