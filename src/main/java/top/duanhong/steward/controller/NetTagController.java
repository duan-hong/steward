package top.duanhong.steward.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import top.duanhong.steward.enumeration.StatusCodeEnum;
import top.duanhong.steward.request.*;
import top.duanhong.steward.response.BaseResponse;
import top.duanhong.steward.service.NetTabService;
import top.duanhong.steward.utils.MethodExcuResult;
import top.duanhong.steward.utils.ResponseUtil;

import javax.validation.Valid;

/**
 * @author duanhong
 * @description 网络标签
 * @date 2019/8/11
 */
@Slf4j
@RestController
@RequestMapping("/netTag")
public class NetTagController {
    @Autowired
    private NetTabService netTabService;

    @GetMapping("/queryNetTagPage")
    public BaseResponse getNetTag(String title,String remark,String tagPath,String page,String pageSize){
        if (StringUtils.isBlank(page)||StringUtils.isBlank(pageSize)){
            log.error("页码参数不能为空");
            return ResponseUtil.getFailedRes("0002","页码参数不能为空");
        }
        NetTagSelectReq req=new NetTagSelectReq();
        req.setNetTagTitle(title);
        req.setTagRemark(remark);
        req.setTagPath(tagPath);
        req.setPage(Integer.valueOf(page));
        req.setPageSize(Integer.valueOf(pageSize));
        MethodExcuResult result=netTabService.netTagSelectByExample(req);
        return BaseResponse.builder()
                .body(result)
                .errorCode(StatusCodeEnum.SUCCESS_CODE.getCode())
                .errorMessage(StatusCodeEnum.SUCCESS_CODE.getMessage())
                .build();
    }

    @PostMapping("/addNetTag")
    public BaseResponse addNetTag(@RequestBody @Valid NetTagAddReq netTagAddReq, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            log.error("添加网络标签时，参数检验失败");
            return ResponseUtil.getFailedRes("0001","参数校验是失败");
        }
        MethodExcuResult result=netTabService.netTagInsert(netTagAddReq);
        if (result.isSuccess()){
            return ResponseUtil.getSuccessRes(result.getResult());
        }else {
            return ResponseUtil.getFailedRes(result.getCode(),result.getMess());
        }
    }

    @DeleteMapping("/deleteNetTag")
    public BaseResponse deleteNetTag(@RequestBody @Valid NetTagDeleteReq deleteReq,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("删除网络标签时错误，可能是为传入Id");
            return ResponseUtil.getFailedRes("0001","参数校验失败");
        }
        MethodExcuResult result=netTabService.deleteNetTag(deleteReq);
        if (result.isSuccess()){
            return ResponseUtil.getSuccessRes(result.getResult());
        }else {
            return ResponseUtil.getFailedRes(result.getCode(),result.getMess());
        }
    }

    @DeleteMapping("/deleteNetTags")
    public BaseResponse NetTagDeleteBatchesReq(@RequestBody @Valid NetTagDeleteBatchesReq req,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("批量删除网络标签时错误，可能是为传入Id");
            return ResponseUtil.getFailedRes("0001","参数校验失败");
        }
        MethodExcuResult result=netTabService.deleteNetTags(req);
        if (result.isSuccess()){
            return ResponseUtil.getSuccessRes(result.getResult());
        }else {
            return ResponseUtil.getFailedRes(result.getCode(),result.getMess());
        }
    }

    @PutMapping("/updateNetTag")
    public BaseResponse updateNetTag(@RequestBody @Valid NetTagUpdateReq req,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("更新网络标签时错误");
            return ResponseUtil.getFailedRes("0001","参数校验失败");
        }
        MethodExcuResult result=netTabService.updateNetTags(req);
        if (result.isSuccess()){
            return ResponseUtil.getSuccessRes(result.getResult());
        }else {
            return ResponseUtil.getFailedRes(result.getCode(),result.getMess());
        }
    }
}
