HOW TO USE:
    
    public static void main(String[] args) {
        SerializationFactory factory = new SerializationFactory();
        InternSerializer serializer = factory.getSerializer(Serializers.JSON);

        Intern intern = new Intern();
        intern.setFirstName("dsdss");

        serializer.serialize("intern1.json",intern);
        
        Intern intern2 = serializer.deserialize("intern1.json");
    }