package com.example.demo.entity;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
public class Order {

//TODO SELECT FROM PLACE BY GEO COORDINATES

/**
 * db.getCollection('place').find({location: {
 *     $geoIntersects: {
 *      $geometry: {
 *        type: "Point",
 *        coordinates: [
 *          1.6637,
 *          89.644
 *         ]
 *       }
 *     }
 *   }
 * })
 */
//TODO SELECT FROM INPLACE BY PLACES ID

    /**
     * db.getCollection('inPlace').find({"place_id": "63f9312e655c48033ed7d504"})
     */
//TODO SELECT FROM PERSON BY PERSON ID FROM PREVIEW QUERY

        private String _id;
        private String place_id;
        private String product_id;
        @Indexed(name = "ttl_index", expireAfterSeconds=20)
        private LocalDateTime time = LocalDateTime.now();

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getPlace_id() {
            return place_id;
        }

        public void setPlace_id(String place_id) {
            this.place_id = place_id;
        }

        public String getProduct_id() {
            return product_id;
        }

        public void setProduct_id(String product_id) {
            this.product_id = product_id;
        }

        public void setTime(LocalDateTime time) {
            this.time = time;
        }

        public LocalDateTime getTime() {
            return time;
        }
}

