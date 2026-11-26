public record EventMap(String source, String event, String listener, String handler) {
    public String describe() {
        return source + " --[" + event + "]--> " + listener + " -> " + handler;
    }
}
