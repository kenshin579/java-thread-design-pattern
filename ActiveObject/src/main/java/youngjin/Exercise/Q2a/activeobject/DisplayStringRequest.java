package youngjin.Exercise.Q2a.activeobject;

class DisplayStringRequest extends youngjin.ActiveObject.activeobject.MethodRequest<Object> {
    private final String string;

    public DisplayStringRequest(Servant servant, String string) {
        super(servant, null);
        this.string = string;
    }

    public void execute() {
        servant.displayString(string);
    }
}
