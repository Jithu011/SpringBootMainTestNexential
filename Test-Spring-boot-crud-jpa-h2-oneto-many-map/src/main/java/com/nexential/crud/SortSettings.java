package com.nexential.crud;

import org.springframework.data.domain.Sort;

public class SortSettings {
    private String key;
    private String direction ;

    public Sort buildSort() {
        switch (direction) {
            case "dsc":
                return Sort.by(key).descending();
            case "asc":
                return Sort.by(key).ascending();
            default:
                return Sort.by(key).descending();
        }
    }
	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
}
