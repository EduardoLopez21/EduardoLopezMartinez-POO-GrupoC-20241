public class Animals {

    private static int nextId = 1; // Variable estática para el próximo ID disponible
    private int idAnimal;
    private String typeAnimal;
    private String birthDate;
    private String arrivalDate;
    private double weight;
    private String diseases;
    private String feedingFrequency;
    private String feedingType;
    private boolean hasVaccines;

    public Animals(String typeAnimal, String birthDate, String arrivalDate, double weight, String diseases, String feedingFrequency, String feedingType, boolean hasVaccines) {
        this.idAnimal = nextId++; // Asignar el próximo ID disponible y luego incrementar nextId
        this.typeAnimal = typeAnimal;
        this.birthDate = birthDate;
        this.arrivalDate = arrivalDate;
        this.weight = weight;
        this.diseases = diseases;
        this.feedingFrequency = feedingFrequency;
        this.feedingType = feedingType;
        this.hasVaccines = hasVaccines;
    }

    // Getters y Setters

    public String getData() {
        String vaccinesInfo = hasVaccines ? "Sí" : "No";
        return String.format("ID: %d, Tipo de Animal: %s, Fecha de nacimiento: %s, Fecha de ingreso: %s, Peso: %.2f, Enfermedades: %s, Frecuencia de alimentación: %s, Tipo de alimentación: %s, Cuenta con vacunas: %s",
                idAnimal, typeAnimal, birthDate, arrivalDate, weight, diseases, feedingFrequency, feedingType, vaccinesInfo);
    }
}


