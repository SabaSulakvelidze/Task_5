public class Video{
    public String id;
    public String title;
    public String data;

    /*public Video(String id, String title) {
        this.id = id;
        this.title = title;
        this.data = "Random video.";
    }*/

    private Video(VideoBuilder videoBuilder){
        this.id = videoBuilder.id;
        this.title = videoBuilder.title;
        this.data = "Random video.";
    }

    public static class VideoBuilder{
        private String id;
        private String title;

        public VideoBuilder setId(String id){
            this.id=id;
            return this;
        }

        public VideoBuilder setTitle(String title){
            this.title=title;
            return this;
        }

        public Video build(){
            return new Video(this);
        }
    }
}