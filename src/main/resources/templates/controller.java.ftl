package ${package.Controller};

import ${package.Service}.${table.serviceName};
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
<#if restControllerStyle>
import org.springframework.web.bind.annotation.RestController;
<#else>
import org.springframework.stereotype.Controller;
</#if>
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>

import javax.annotation.Resource;

/**
 * Msw-${table.comment!}-Controller
 *
 * @author ${author}
 * @date ${.now?string("yyyy/M/d HH:mm")}
 */
@Validated
<#if restControllerStyle>
@RestController
<#else>
@Controller
</#if>
@RequestMapping("<#if package.ModuleName??>/${package.ModuleName}</#if>")
<#if kotlin>
class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
<#if superControllerClass??>
public class ${table.controllerName} extends ${superControllerClass} {
<#else>
public class ${table.controllerName} {
</#if>

    @Resource
    ${table.serviceName} ${table.serviceName?uncap_first};

}
</#if>
