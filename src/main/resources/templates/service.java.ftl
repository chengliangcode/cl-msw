package ${package.Service};

/**
 * Msw-${table.comment!}-Service
 *
 * @author ${author}
 * @date ${.now?string("yyyy/M/d HH:mm")}
 */
<#if kotlin>
interface ${table.serviceName} : ${superServiceClass}<${entity}>
<#else>
public interface ${table.serviceName} {

}
</#if>
