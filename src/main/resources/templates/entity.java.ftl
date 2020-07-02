package ${package.Entity};

<#if swagger2>
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
</#if>
import javax.persistence.Id;
<#if table.convert>
import javax.persistence.Table;
</#if>
<#--import javax.persistence.Column;-->
<#if entityLombokModel>
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
</#if>

/**
 * Msw-${table.comment!}-实体类
 *
 * @author ${author}
 * @date ${.now?string("yyyy/M/d HH:mm")}
 */
<#if entityLombokModel>
@Data
    <#if superEntityClass??>
@EqualsAndHashCode(callSuper = true)
    <#else>
@EqualsAndHashCode(callSuper = false)
    </#if>
@Accessors(chain = true)
</#if>
<#if table.convert>
@Table(name = "${table.name}")
</#if>
<#if swagger2>
@ApiModel(value="${entity}对象", description="${table.comment!}")
</#if>
<#if superEntityClass??>
public class ${entity} extends ${superEntityClass}<#if activeRecord><${entity}></#if> {
<#elseif activeRecord>
public class ${entity} extends Model<${entity}> {
<#else>
public class ${entity} {
</#if>

<#if entitySerialVersionUID>
    private static final long serialVersionUID = 1L;
</#if>
<#-- ----------  BEGIN 字段循环遍历  ---------->
<#list table.fields as field>
    <#if field.keyFlag>
        <#assign keyPropertyName="${field.propertyName}"/>
    </#if>

    <#if field.comment!?length gt 0>
        <#if swagger2>
    @ApiModelProperty(value = "${field.comment}")
        <#else>
    /**
     * ${field.comment}
     */
        </#if>
    </#if>
    <#if field.keyFlag>
        <#-- 主键 -->
<#--        <#if field.keyIdentityFlag>-->
<#--    @TableId(value = "${field.name}", type = IdType.AUTO)-->
<#--        <#elseif idType??>-->
<#--    @TableId(value = "${field.name}", type = IdType.${idType})-->
<#--        <#elseif field.convert>-->
<#--    @TableId("${field.name}")-->
<#--        </#if>-->
    @Id
        <#-- 普通字段 -->
    <#else>
    <#-- -----   存在字段填充设置   ----->
<#--    @Column(name = "${field.name}")-->
<#--        <#if field.convert>-->
<#--    @TableField(value = "${field.name}", fill = FieldFill.${field.fill})-->
<#--        <#else>-->
<#--    @TableField(fill = FieldFill.${field.fill})-->
<#--        </#if>-->
<#--    <#elseif field.convert>-->
<#--    @TableField("${field.name}")-->
<#--    </#if>-->
<#--    &lt;#&ndash; 乐观锁注解 &ndash;&gt;-->
<#--    <#if (versionFieldName!"") == field.name>-->
<#--    @Version-->
<#--    </#if>-->
<#--    &lt;#&ndash; 逻辑删除注解 &ndash;&gt;-->
<#--    <#if (logicDeleteFieldName!"") == field.name>-->
<#--    @TableLogic-->
    </#if>
    private ${field.propertyType} ${field.propertyName};
</#list>
<#------------  END 字段循环遍历  ---------->
<#if !entityLombokModel>
    <#list table.fields as field>
        <#if field.propertyType == "boolean">
            <#assign getprefix="is"/>
        <#else>
            <#assign getprefix="get"/>
        </#if>
    public ${field.propertyType} ${getprefix}${field.capitalName}() {
        return ${field.propertyName};
    }

    <#if entityBuilderModel>
    public ${entity} set${field.capitalName}(${field.propertyType} ${field.propertyName}) {
    <#else>
    public void set${field.capitalName}(${field.propertyType} ${field.propertyName}) {
    </#if>
        this.${field.propertyName} = ${field.propertyName};
        <#if entityBuilderModel>
        return this;
        </#if>
    }
    </#list>
</#if>

<#if entityColumnConstant>
    <#list table.fields as field>
    public static final String ${field.name?upper_case} = "${field.propertyName}";

    </#list>
</#if>
<#if activeRecord>
    @Override
    protected Serializable pkVal() {
    <#if keyPropertyName??>
        return this.${keyPropertyName};
    <#else>
        return null;
    </#if>
    }

</#if>
<#if !entityLombokModel>
    @Override
    public String toString() {
        return "${entity}{" +
    <#list table.fields as field>
        <#if field_index==0>
            "${field.propertyName}=" + ${field.propertyName} +
        <#else>
            ", ${field.propertyName}=" + ${field.propertyName} +
        </#if>
    </#list>
        "}";
    }
</#if>
}
