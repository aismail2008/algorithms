package com.code.test.problemset.companies.Booking;

public class DuplicatedHotelNames {
//
//    Duplicated hotel names
//
//    Based on customer research, we know that our guests get confused when they are searching for accommodation and they found multiple hotels with the same name in the same city.
//
//    To avoid this, we want to create a tool to identify "confusing" cities: cities with at least 3 hotels with the same name.
//
//    Given a list of tuples (hotel_id, hotel_name, city) return a list of all "confusing" cities.
//
//            Input: [
//    {hotel_1234, "Sheraton", "Amsterdam"} ,
//    {hotel_1000, "Sheraton", "Buenos Aires"} ,
//    {hotel_1001, "Hilton", "Amsterdam"} ,
//    {hotel_1002, "Royal Palace", "Bogota"} ,
//    {hotel_1003, "Hilton", "Amsterdam"} ,
//    {hotel_1004, "Sheraton", "Buenos Aires"} ,
//    {hotel_1005, "Sheraton", "Buenos Aires"}
//]
//
//    Output: [ "Buenos Aires" ]
//    Contact
//    Nico Komanski
//    Clarifications
//    Every hotel_id will be unique
//    If a city has multiple hotels with at least 3 repetitions (a "super confusing" city) we still want it to appear only once in the output.
//    Follow-ups
//    We want a list of all the sets of hotels which share the same name and are in the same city.
//
//            Input: same as problem statement
//    Output: [ {hotel_1000, hotel_1004, hotel_1005}, {hotel_1001, hotel_1003} ]
//    Expectations
//    Find a faster way of identifying duplicates than brute force comparison. There should be a data structure (hash/map) somewhere that is used to make lookups fast. Doing all linear traversal over lists is not enough.
//    Candidate should be able to answer basic time and space complexity questions.
//    Example solution
//    /*
//    H = number of hotels
//    C = number of cities
//    Assuming size of hotel and city names is constant
//    O(H * (log C + log H))
//    */
//    struct hotel {
//        string id;
//        string name;
//        string city;
//    }
//
//    vector<set<string>> get_set_of_hotels(vector<hotel> hotels) {
//        map<string, map<string, set<string>>> city_to_hotels;
//
//        for(hotel h: hotels) { // O(H)
//            if (city_to_hotels.count(h.city) == 0) { // O(log C)
//                city_to_hotels[h.city] = map<string, set<string>>();
//            }
//
//            if (city_to_hotels[h.city].count(h.name) == 0) { // O(log C + log H)
//                city_to_hotels[h.city][h.name] = set<string>();
//            }
//
//            city_to_hotels[h.city][h.name].insert(h.id); // O(log C + log H)
//        }
//
//        vector<string> result;
//
//        for(auto city_hotels : city_to_hotels) { // O(C)
//            for(auto name_ids : city_hotels.second)
//                if (name_ids.size() >= 3) {
//                    result.push_back(city_hotels.first);
//                    break;
//                }
//        }
//
//        // FOLLOW UP
//        vector<set<string>> result;
//        for(auto city_hotels : city_to_hotels)
//            for(auto name_ids : city_hotels.second)
//                result.push_back(name_ids.second);
//        // FOLLOW UP
//
//
//        return result;
//    }
//    Example basic Perl solution with an amortised runtime complexity O(H*L + C) (feel free to disprove me, I might be too optimistic and miss something)
//
//    use strict;
//    use warnings;
//    use List::Util qw(max reduce);
//    my @hotels = [[1, "Sheraton", "Amsterdam"], [1000, "Sheraton", "Buenos Aires"], [1001, "Hilton", "Amsterdam"], [1002, "Talleres", "Cordoba"], [1003, "Hilton", "Amsterdam"], [1004, "Sheraton", "Buenos Aires"], [1005, "Sheraton", "Buenos Aires"]];
//    my $breakdown = reduce {
//        my ($_id, $name, $city) = @$b;
//        $a->{$city} //= {};
//        $a->{$city}{__max_cnt__} = max(++($a->{$city}{$name }//=0), $a->{$city}{__max_cnt__}//0);
//        $a
//    } +{}, @hotels;
//    my @confusing = grep { $breakdown->{$_}{__max_cnt__} >= 3 ? $_ : undef } keys %$breakdown;
//
//
//
//    Example Solution in Js, feel free to enhance it
//
//const hotels = [
//            [1, "Sheraton", "Amsterdam"],
//            [1000, "Sheraton", "Buenos Aires"],
//            [1001, "Hilton", "Amsterdam"],
//            [1002, "Talleres", "Cordoba"],
//            [1003, "Hilton", "Amsterdam"],
//            [1004, "Sheraton", "Buenos Aires"],
//            [1005, "Sheraton", "Buenos Aires"]
//            ];
//const hash = hotels.reduce((acc, hotel) => {
//        let o = acc[hotel[1]] || {}
//const count = o && o.count ? o.count : 0;
//        o.count = count + 1;
//        o.city = hotel[2]
//        acc[hotel[1]] = o
//
//        return acc
//    }, {});
//
//
//const confusing =[]
//            Object.values(hash).forEach(hotel => {
//        if(hotel.count >= 3) {
//            confusing.push(hotel.city)
//        }
//    })
//
//            console.log(confusing);
//
//
//
//    Example Solution in Python:
//
//    def get_confusing_cities(hotel_info):
//    confusing_cities, city_to_hotel_dict = {}, {}
//
//    for hotel_id, hotel_name, hotel_city in hotel_info:
//            if hotel_city not in city_to_hotel_dict:
//    city_to_hotel_dict[hotel_city] = {}
//        if hotel_name not in city_to_hotel_dict[hotel_city]:
//    city_to_hotel_dict[hotel_city][hotel_name] = 1
//            else:
//    city_to_hotel_dict[hotel_city][hotel_name] += 1
//
//    print city_to_hotel_dict
//
//
//    for hotel_city, hotel_name_dict in city_to_hotel_dict.items():
//            for hotel_name, hotel_count in hotel_name_dict.items():
//            if hotel_count >= 3 and hotel_city not in confusing_cities:
//    confusing_cities[hotel_city] = None
//
//    return confusing_cities.keys()
//
//
//    Example solution in Clojure
//            (def problem-input [[:hotel_1234, "Sheraton", "Amsterdam"],
//                    [:hotel_1000, "Sheraton", "Buenos Aires"],
//                     [:hotel_1001, "Hilton", "Amsterdam"],
//                     [:hotel_1002, "Royal Palace", "Bogota"],
//                     [:hotel_1003, "Hilton", "Amsterdam"],
//                     [:hotel_1004, "Sheraton", "Buenos Aires"],
//                     [:hotel_1005, "Sheraton", "Buenos Aires"]])
//
//(defn solution [hotels]
//            (->> hotels
//            (map rest)
//       (frequencies)
//            (filter #(>= (second %) 3))
//            (map #(-> % first second))))
//
//            (defn follow-up [hotels]
//            (->> hotels
//            (group-by rest)
//       (vals)
//            (filter #(> (count %) 1))
//            (map #(map first %))))
//
//

}
