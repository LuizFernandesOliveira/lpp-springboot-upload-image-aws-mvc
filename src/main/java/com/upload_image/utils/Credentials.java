package com.upload_image.utils;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Credentials {
    private String email;
    private String password;
}
