package com.thoughtworks.mstorderservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class GoodAdditionDTO {

    @JsonProperty("good_id")
    private String goodId;

    @JsonProperty("quantity")
    private long quantity;

    @JsonProperty("user_id")
    private String userId;
}
