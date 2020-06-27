package top.duanhong.steward.mapper.gmapper;

import org.apache.ibatis.annotations.Param;
import top.duanhong.steward.entity.po.MgmtRivalChl;
import top.duanhong.steward.entity.po.MgmtRivalChlExample;

import java.util.List;

public interface MgmtRivalChlMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mgmt_rival_chl_base
     *
     * @mbg.generated
     */
    long countByExample(MgmtRivalChlExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mgmt_rival_chl_base
     *
     * @mbg.generated
     */
    int deleteByExample(MgmtRivalChlExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mgmt_rival_chl_base
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long channelId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mgmt_rival_chl_base
     *
     * @mbg.generated
     */
    int insert(MgmtRivalChl record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mgmt_rival_chl_base
     *
     * @mbg.generated
     */
    int insertSelective(MgmtRivalChl record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mgmt_rival_chl_base
     *
     * @mbg.generated
     */
    List<MgmtRivalChl> selectByExample(MgmtRivalChlExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mgmt_rival_chl_base
     *
     * @mbg.generated
     */
    MgmtRivalChl selectByPrimaryKey(Long channelId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mgmt_rival_chl_base
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") MgmtRivalChl record, @Param("example") MgmtRivalChlExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mgmt_rival_chl_base
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") MgmtRivalChl record, @Param("example") MgmtRivalChlExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mgmt_rival_chl_base
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(MgmtRivalChl record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mgmt_rival_chl_base
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(MgmtRivalChl record);
}
