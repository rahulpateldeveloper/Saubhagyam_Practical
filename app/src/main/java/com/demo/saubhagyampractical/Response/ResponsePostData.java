package com.demo.saubhagyampractical.Response;

import java.util.List;

public class ResponsePostData {

    public String message_count;
    public String flag;
    public String msg;
    public String next_offset;
    public List<DataList> data;

    public class DataList {
        public String post_id;
        public String location_name;
        public String post_type;
        public String restaurant_id;
        public String user_id;
        public String image_url;
        public String restaurant_name;
        public String user_profile_pic;
        public String username;
        public String name;
        public String like_count;
        public String created_date;
        public String is_chef;
        public String followers;
        public String distance;
        public String feedback_count;
        public String feedback;
        public String comment_count;
        public String share_count;
        public String view_count;
        public String followers_count;

        public List<Post_image> post_image;

        public class Post_image {
            public String image_id;
            public String post_id;
            public String image_url;
            public String is_del;
        }
    }
}
