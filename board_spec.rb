require 'java'
java_import 'Board'

describe "Board" do
  it "should have positions" do
    Board.new.positions.class.should == HashMap
  end

end
