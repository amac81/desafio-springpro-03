package pt.bitclinic.desafio_springpro_03.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

//https://bootify.io/spring-boot/pagination-in-spring-boot-rest-api.html

/*Warning: Serializing PageImpl instances as-is is not supported, 
meaning that there is no guarantee about the stability of the resulting JSON structure!
*/

@Configuration
@EnableSpringDataWebSupport(
        pageSerializationMode = EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO
)
public class AppConfig {

}
