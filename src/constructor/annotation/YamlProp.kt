package constructor.annotation

@Retention(value = AnnotationRetention.RUNTIME)
@Target(allowedTargets = [AnnotationTarget.PROPERTY])
internal annotation class YamlProp(val yamlName: String = "")