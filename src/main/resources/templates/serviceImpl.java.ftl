package ${package.ServiceImpl};

import ${package.Mapper}.${table.mapperName};
import ${package.Service}.${table.serviceName};
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Msw${table.comment!}-ServiceImpl
 *
 * @author ${author}
 * @date ${.now?string("yyyy/M/d HH:mm")}
 */
@Service
<#if kotlin>
open class ${table.serviceImplName} : ${superServiceImplClass}<${table.mapperName}, ${entity}>(), ${table.serviceName} {

}
<#else>
public class ${table.serviceImplName} implements ${table.serviceName} {

    @Resource
    ${table.mapperName} ${table.mapperName?uncap_first};

}
</#if>
