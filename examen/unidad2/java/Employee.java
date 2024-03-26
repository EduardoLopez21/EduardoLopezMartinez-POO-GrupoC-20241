class Employee {
    private String nombre;
    private String apellidos;
    private String fechaNacimiento;
    private String fechaIngreso;
    private String rfc;
    private String curp;
    private double salario;
    private String horario;
    private String rol;

    public Employee(String nombre, String apellidos, String fechaNacimiento, String fechaIngreso, String rfc, String curp, double salario, String horario, String rol) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaIngreso = fechaIngreso;
        this.rfc = rfc;
        this.curp = curp;
        this.salario = salario;
        this.horario = horario;
        this.rol = rol;
    }

    public String getData() {
        return String.format("Nombre: %s %s, Fecha de nacimiento: %s, Fecha de ingreso: %s, RFC: %s, CURP: %s, Salario: %.2f, Horario: %s, Rol: %s",
                this.nombre, this.apellidos, this.fechaNacimiento, this.fechaIngreso, this.rfc, this.curp, this.salario, this.horario, this.rol);
    }
}
