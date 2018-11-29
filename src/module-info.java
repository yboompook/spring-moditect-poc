module install {

    requires java.base;
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.base;
    requires javafx.swing;
    requires spring.orm;
//    requires spring.jdbc;
//    requires spring.jcl;
//    requires spring.expression;
//    requires spring.data.commons;
    requires spring.beans;
//    requires spring.aop;
    requires spring.data.jpa;
    requires spring.tx;
//    requires spring.core;
    requires slf4j.api;
    requires spring.context;
    requires org.apache.logging.log4j.core;
    requires org.apache.logging.log4j;
    requires h2;
    requires hibernate.entitymanager;
    requires org.hibernate.orm.core;
//    requires org.hibernate.commons.annotations;
//    requires jmx;
    requires jdk.jconsole;
    requires commons.dbcp2;
    requires java.persistence;
    requires commons.beanutils;
    requires java.sql;
    requires java.desktop;
//    requires java.transaction;

    requires jdk.unsupported;

    exports install;
//    exports install.bll.springConf;
    opens install to spring.core;
//    opens install.bll to spring.core;
//    opens install.bll.springConf to spring.core;
    opens install.dao to spring.beans, spring.data.jpa, spring.context;
    opens install.bo to spring.beans, org.hibernate.commons.annotations, spring.context;
    opens install.service to spring.beans, spring.context;
}