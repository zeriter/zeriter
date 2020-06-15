package com.zeriter.reqAndResp;

import com.zeriter.entity.Zgroup;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListGroupsResp {
    private List<Zgroup> groups;

}
