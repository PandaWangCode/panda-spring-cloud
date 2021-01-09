package nx.panda.main03_jvm;

/**
 * istort_2 操作码+操作数
 * 1、加载和存贮指令
 * [i,f,l,d.a]load store
 * bipush sipush ldc ldc_w ldc2_w... acontst_XXX
 * 2、对象的创建和访问
 *  new newarry,XXXarry
 *  get put。。
 *3、栈
 *  pop pop2
 *4、ifeq iflt ifle ifne。。。
 *  goto...
 * 5、invokevitrul
 *          interface
 *          static
 *          special
 */
public class IntTest {
    public static void main(String[] args) {
        int a = 100;
        int b = 2;
        int c = a+b;
        System.out.println(c);
    }

}

/**----------------------
 * https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-4.html

ClassFile {
    u4             magic;
    u2             minor_version;
    u2             major_version;
    u2             constant_pool_count;
    cp_info        constant_pool[constant_pool_count-1];
    u2             access_flags;
    u2             this_class;
    u2             super_class;
    u2             interfaces_count;
    u2             interfaces[interfaces_count];
    u2             fields_count;
    field_info     fields[fields_count];
    u2             methods_count;
    method_info    methods[methods_count];
    u2             attributes_count;
    attribute_info attributes[attributes_count];
}

**/

/**-----------------------------

cp_info {
    u1 tag;
    u1 info[];
}

Table 4.4-A. Constant pool tags

Constant Type	Value
CONSTANT_Class	7
CONSTANT_Fieldref	9
CONSTANT_Methodref	10
CONSTANT_InterfaceMethodref	11
CONSTANT_String	8
CONSTANT_Integer	3
CONSTANT_Float	4
CONSTANT_Long	5
CONSTANT_Double	6
CONSTANT_NameAndType	12
CONSTANT_Utf8	1
CONSTANT_MethodHandle	15
CONSTANT_MethodType	16
CONSTANT_InvokeDynamic	18


**/

