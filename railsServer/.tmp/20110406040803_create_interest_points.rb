class CreateInterestPoints < ActiveRecord::Migration
  def self.up
    create_table :interest_points do |t|

      t.timestamps
    end
  end

  def self.down
    drop_table :interest_points
  end
end
