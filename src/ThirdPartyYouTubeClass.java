import java.util.HashMap;

//ეს კლასი წარმოადგენს ობიექტს რომელიც ასრულებს "მთავარ" მოქმედებებს კლიენტისთვის.
public class ThirdPartyYouTubeClass implements ThirdPartyYouTubeLib {

    @Override
    public HashMap<String, Video> popularVideos() {
        connectToServer("http://www.youtube.com");
        return getPopularVideos();
    }

    @Override
    public Video getVideo(String videoId) {
        connectToServer("http://www.youtube.com/" + videoId);
        return getSomeVideo(videoId);
    }

    private int random(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }
    //ეს მეთოდი ახდენს ინტერნეტთან კავშირის დაყოვნების სიმულაციას.
    private void experienceNetworkLatency() {
        int randomLatency = random(5, 10);
        for (int i = 0; i < randomLatency; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
    //დაიბეჭდება საიტთან დაკავშირების მცდელობის შესახებ და დაყოვნების შემდეგ დაიბეჭდება შეტყობინება წარმატებული კონტაქტის შემსახებ.
    private void connectToServer(String server) {
        System.out.print("Connecting to " + server + "... ");
        experienceNetworkLatency();
        System.out.print("Connected!" + "\n");
    }
    //ეს მეთოდი ახდენს იუთუბზე ხუთი პოპულარული ვიდეოს მოძებნის სიმულაციას
    private HashMap<String, Video> getPopularVideos() {
        System.out.print("Downloading populars... ");
        experienceNetworkLatency();
        HashMap<String, Video> hmap = new HashMap<String, Video>();
        //ეს ნაწილი ჩანაცვლდა Builder-ით
        hmap.put("catzzzzzzzzz", new Video.VideoBuilder().setId("sadgahasgdas").setTitle("Catzzzz.avi").build());
        hmap.put("mkafksangasj", new Video.VideoBuilder().setId("mkafksangasj").setTitle("Dog play with ball.mp4").build());
        hmap.put("dancesvideoo", new Video.VideoBuilder().setId("asdfas3ffasd").setTitle("Dancing video.mpq").build());
        hmap.put("dlsdk5jfslaf", new Video.VideoBuilder().setId("dlsdk5jfslaf").setTitle("Barcelona vs RealM.mov").build());
        hmap.put("3sdfgsd1j333", new Video.VideoBuilder().setId("3sdfgsd1j333").setTitle("Programing lesson#1.avi").build());
        System.out.print("Done!" + "\n");
        return hmap;
    }
    //ეს მეთდი ახდენს იუთუბზე რენდომ ვიდეოს მოძებნის სიმულაციას
    private Video getSomeVideo(String videoId) {
        System.out.print("Downloading video... ");
        experienceNetworkLatency();
        Video video = new Video.VideoBuilder().setId(videoId).setTitle("Some video title").build();
        System.out.print("Done!" + "\n");
        return video;
    }
}

