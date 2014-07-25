package sk.apupo.shoppinglist.enums;

public enum ApplicationControllerState {
	NONE(0);
	
    private final int intValue;

    private ApplicationControllerState(final int intValue) {
        this.intValue = intValue;
    }

    public Integer toInt() { return this.intValue; }

    public static ApplicationControllerState fromInt(int value) {
        for(ApplicationControllerState type : values()) {
            if(type.toInt() == value) return type;
        }

        return ApplicationControllerState.NONE;
    }
}
