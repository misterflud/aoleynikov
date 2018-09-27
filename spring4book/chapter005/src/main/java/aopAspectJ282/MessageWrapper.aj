package aopAspectJ282;


/**
 * Created by AOleynikov on 26.09.2018.
 */
public aspect MessageWrapper {
    private String prefix;
    private String suffix;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    pointcut doWriting() :
            execution(* aopAspectJ282.MessageWriter);
    before() : doWriting() {
        System.out.println(prefix);
    }
    after() : doWriting() {
        System.out.println(suffix);
    }
}
