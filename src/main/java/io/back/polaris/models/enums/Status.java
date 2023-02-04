package io.back.polaris.models.enums;

public enum Status {

    UNKNOW(0, "inconnu"),
    OPEN(1, "ouvert"),
    ANALYSIS(2, "analyse"),
    ITEM_FIND(3, "item trouvé"),
    CHECK(4, "vérification"),
    DOWNLOAD(5, "téléchargement"),
    FIRST_VALIDATION(6, "première validation"),
    LAST_VALIDATION(7, "dernière validation"),
    REJECT(8, "rejeté"),
    STANDBY(9, "en attente"),
    COMPLETE(10, "complété"),
    STOP(11, "en pause"),
    ABANDON(12, "abandonné");

    
    private Status(Integer id, String code) {
        this.id = id;
        this.code = code;
    }

    private final Integer id;

    private final String code;

    
    public Integer getId() {
        return id;
    }

    public String getCode() {
        return code;
    }   
    
    public static Status getStatusById(Integer id){
        Status status = Status.UNKNOW;
        for (Status targetStatus : Status.values()) {
            if(status.getId().equals(id)){
                status = targetStatus;
            }
        }
        return status;
    }
}
