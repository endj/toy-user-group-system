/*
 * This file is generated by jOOQ.
 */
package se.edinjakupovic.generated.tables;


import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;

import se.edinjakupovic.generated.Indexes;
import se.edinjakupovic.generated.Keys;
import se.edinjakupovic.generated.Social;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class FlywaySchemaHistory extends TableImpl<Record> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>social.flyway_schema_history</code>
     */
    public static final FlywaySchemaHistory FLYWAY_SCHEMA_HISTORY = new FlywaySchemaHistory();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<Record> getRecordType() {
        return Record.class;
    }

    /**
     * The column <code>social.flyway_schema_history.installed_rank</code>.
     */
    public final TableField<Record, Integer> INSTALLED_RANK = createField(DSL.name("installed_rank"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>social.flyway_schema_history.version</code>.
     */
    public final TableField<Record, String> VERSION = createField(DSL.name("version"), SQLDataType.VARCHAR(50), this, "");

    /**
     * The column <code>social.flyway_schema_history.description</code>.
     */
    public final TableField<Record, String> DESCRIPTION = createField(DSL.name("description"), SQLDataType.VARCHAR(200).nullable(false), this, "");

    /**
     * The column <code>social.flyway_schema_history.type</code>.
     */
    public final TableField<Record, String> TYPE = createField(DSL.name("type"), SQLDataType.VARCHAR(20).nullable(false), this, "");

    /**
     * The column <code>social.flyway_schema_history.script</code>.
     */
    public final TableField<Record, String> SCRIPT = createField(DSL.name("script"), SQLDataType.VARCHAR(1000).nullable(false), this, "");

    /**
     * The column <code>social.flyway_schema_history.checksum</code>.
     */
    public final TableField<Record, Integer> CHECKSUM = createField(DSL.name("checksum"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>social.flyway_schema_history.installed_by</code>.
     */
    public final TableField<Record, String> INSTALLED_BY = createField(DSL.name("installed_by"), SQLDataType.VARCHAR(100).nullable(false), this, "");

    /**
     * The column <code>social.flyway_schema_history.installed_on</code>.
     */
    public final TableField<Record, LocalDateTime> INSTALLED_ON = createField(DSL.name("installed_on"), SQLDataType.LOCALDATETIME(0).nullable(false).defaultValue(DSL.field(DSL.raw("CURRENT_TIMESTAMP"), SQLDataType.LOCALDATETIME)), this, "");

    /**
     * The column <code>social.flyway_schema_history.execution_time</code>.
     */
    public final TableField<Record, Integer> EXECUTION_TIME = createField(DSL.name("execution_time"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>social.flyway_schema_history.success</code>.
     */
    public final TableField<Record, Byte> SUCCESS = createField(DSL.name("success"), SQLDataType.TINYINT.nullable(false), this, "");

    private FlywaySchemaHistory(Name alias, Table<Record> aliased) {
        this(alias, aliased, null);
    }

    private FlywaySchemaHistory(Name alias, Table<Record> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>social.flyway_schema_history</code> table
     * reference
     */
    public FlywaySchemaHistory(String alias) {
        this(DSL.name(alias), FLYWAY_SCHEMA_HISTORY);
    }

    /**
     * Create an aliased <code>social.flyway_schema_history</code> table
     * reference
     */
    public FlywaySchemaHistory(Name alias) {
        this(alias, FLYWAY_SCHEMA_HISTORY);
    }

    /**
     * Create a <code>social.flyway_schema_history</code> table reference
     */
    public FlywaySchemaHistory() {
        this(DSL.name("flyway_schema_history"), null);
    }

    public <O extends Record> FlywaySchemaHistory(Table<O> child, ForeignKey<O, Record> key) {
        super(child, key, FLYWAY_SCHEMA_HISTORY);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Social.SOCIAL;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.asList(Indexes.FLYWAY_SCHEMA_HISTORY_FLYWAY_SCHEMA_HISTORY_S_IDX);
    }

    @Override
    public UniqueKey<Record> getPrimaryKey() {
        return Keys.KEY_FLYWAY_SCHEMA_HISTORY_PRIMARY;
    }

    @Override
    public FlywaySchemaHistory as(String alias) {
        return new FlywaySchemaHistory(DSL.name(alias), this);
    }

    @Override
    public FlywaySchemaHistory as(Name alias) {
        return new FlywaySchemaHistory(alias, this);
    }

    @Override
    public FlywaySchemaHistory as(Table<?> alias) {
        return new FlywaySchemaHistory(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public FlywaySchemaHistory rename(String name) {
        return new FlywaySchemaHistory(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public FlywaySchemaHistory rename(Name name) {
        return new FlywaySchemaHistory(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public FlywaySchemaHistory rename(Table<?> name) {
        return new FlywaySchemaHistory(name.getQualifiedName(), null);
    }
}
