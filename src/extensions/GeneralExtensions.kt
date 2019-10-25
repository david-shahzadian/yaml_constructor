package extensions

import annotation.YamlProp
import kotlin.reflect.KParameter
import kotlin.reflect.full.declaredMemberProperties
import kotlin.reflect.full.findAnnotation
import kotlin.reflect.full.primaryConstructor

internal inline fun <reified T : Any> T.getPrimaryConstructorAnnotatedYamlParamPairs(): List<Pair<String, Any?>> {
    return getPrimaryConstructorParameters()
        .mapNotNull { param ->
            this::class.declaredMemberProperties
                .firstOrNull { it.name == param.name && it.findAnnotation<YamlProp>() != null }
                ?.let { property ->
                    val yamlFieldName = property.findAnnotation<YamlProp>()!!.yamlName
                    val nameToReturn = if (yamlFieldName.isNotBlank()) {
                        yamlFieldName
                    } else property.name
                    nameToReturn to property.getter.call(this)
                }
        }
}

inline fun <reified T : Any> T.getPrimaryConstructorParameters(): List<KParameter> {
    return this::class.primaryConstructor?.parameters
        ?: throw Throwable("No primary constructor found for class ${this::class.java.simpleName}")
}