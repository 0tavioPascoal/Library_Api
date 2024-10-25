package com.Tavin.libraryApi.dto;

import java.util.Set;
import java.util.UUID;

public record BookRecordDto (String title,
                             UUID publisherId,
                             String reviewComment, Set<UUID> auhtorsIds){

}
