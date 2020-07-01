package ${package.Mapper};

import ${package.Entity}.${entity};
import com.cl.msw.component.base.MswBaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * Msw-${table.comment!}-Mapper
 *
 * @author ${author}
 * @date ${.now?string("yyyy/M/d HH:mm")}
 */
<#if kotlin>
interface ${table.mapperName} : ${superMapperClass}<${entity}>
<#else>
@Mapper
public interface ${table.mapperName} extends MswBaseMapper<${entity}> {

}
</#if>
